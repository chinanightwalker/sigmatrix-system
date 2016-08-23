package com.sigmatrix.sc.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName
 * @Description
 * @Author
 * @Date
 * @Revision
 */

/**
 * @author user
 * 修改mybaitis Generator生成的实体类、mapper、xml，加入表的前缀
 *
 */
public class MybaitsGeneratorUpdate {
	public static String entityFolder = "D:/workspace/mse/mse-common/src/main/java/com/sigmatrix/sc/entity/v1";
	public static String mapperFolder = "D:/workspace/mse/mse-common/src/main/java/com/sigmatrix/sc/dao/mapper/v1/auto";
	public static String xmlFolder = "D:/workspace/mse/mse-common/src/main/java/com/sigmatrix/sc/dao/mapper/v1/auto/xml";
	public static String tablePrefix = "_scld01";
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		updateEntity();
		updateMapper();
		updateXml();
	}
	
	public static void updateEntity() throws Exception{
		File f = new File(entityFolder);
		for(File file:f.listFiles()){
			if(file.isFile()){
				BufferedReader bufReader = new BufferedReader(new FileReader(file));
				String s = bufReader.readLine();
				StringBuffer buf = new StringBuffer();
				while(s!=null){
					buf.append(s+"\n");
					s = bufReader.readLine();
				}
				bufReader.close();
				//已经修改过，退出
				if(buf.toString().contains("TablePrefix")){
					continue;
				}
				Pattern p = Pattern.compile("public class \\S+");
		        Matcher m = p.matcher(buf.toString());
		        if(m.find()){
		        	PrintWriter printWriter = new PrintWriter(file);//替换后输出的文件位置
					printWriter.write(buf.toString().replace(m.group(), m.group()+" extends TablePrefix"));
					printWriter.flush();
					printWriter.close();
					System.out.println(file.toString());
					System.out.println(m.group()+"-------->"+m.group()+" extends TablePrefix");
		        } 
			}
		}
		System.out.println("\n\n-------------entity修改完毕-------------------\n\n");
	}
	
	public static void updateMapper() throws Exception{
		File f = new File(mapperFolder);
		for(File file:f.listFiles()){
			if(file.isFile()){
				BufferedReader bufReader = new BufferedReader(new FileReader(file));
				String s = bufReader.readLine();
				StringBuffer buf = new StringBuffer();
				while(s!=null){
					buf.append(s+"\n");
					s = bufReader.readLine();
				}
				bufReader.close();
				String newStr = null;
				Pattern p = Pattern.compile("deleteByPrimaryKey\\(\\S+ \\S+\\);");
		        Matcher m = p.matcher(buf.toString());
		        if(m.find()){
		        	String group = m.group();
		        	StringBuffer groupBuffer = new StringBuffer(group);
		        	String keyString = group.split(" ")[1].replace(");", "");
		        	groupBuffer.insert(groupBuffer.indexOf("(")+1, 
		        			"@Param(\""+keyString+"\") ");
		        	groupBuffer.insert(groupBuffer.lastIndexOf(")"), 
		        			", @Param(\"tablePrefix\") String tablePrefix");
		        	newStr = buf.toString().replace(group, groupBuffer.toString());
		        	System.out.println(file.toString());
		        	System.out.println(group+"---------->"+groupBuffer.toString());
		        }else{ //已经修改过，退出
		        	continue;
		        } 
		        p = Pattern.compile("selectByPrimaryKey\\(\\S+ \\S+\\);");
		        m = p.matcher(buf.toString());
		        if(m.find()){
		        	String group = m.group();
		        	StringBuffer groupBuffer = new StringBuffer(group);
		        	String keyString = group.split(" ")[1].replace(");", "");
		        	groupBuffer.insert(groupBuffer.indexOf("(")+1, 
		        			"@Param(\""+keyString+"\") ");
		        	groupBuffer.insert(groupBuffer.lastIndexOf(")"), 
		        			", @Param(\"tablePrefix\") String tablePrefix");
		        	newStr = newStr.replace(group, groupBuffer.toString());
		        	System.out.println(group+"---------->"+groupBuffer.toString());
		        }
		        PrintWriter printWriter = new PrintWriter(file);//替换后输出的文件位置
				printWriter.write(newStr);
				printWriter.flush();
				printWriter.close();
			}
		}
		System.out.println("\n\n-------------mapper修改完毕-------------------\n\n");
	}
	
	public static void updateXml() throws Exception{
		File f = new File(xmlFolder);
		for(File file:f.listFiles()){
			if(file.isFile()){
				BufferedReader bufReader = new BufferedReader(new FileReader(file));
				String s = bufReader.readLine();
				StringBuffer buf = new StringBuffer();
				while(s!=null){
					buf.append(s+"\n");
					s = bufReader.readLine();
				}
				bufReader.close();
				String newStr = buf.toString();
				if(newStr.contains("${tablePrefix}")){
					continue;
				}
				if(tablePrefix!=null && tablePrefix.trim().length()>0){
					newStr = newStr.replace(tablePrefix, "");
				}
				Pattern p = Pattern.compile("from \\S+");
		        Matcher m = p.matcher(newStr);
		        if(m.find()){
		        	String group = m.group();
		        	String tableName = group.split(" ")[1];
		        	newStr = newStr.replace("from "+tableName, "from ${tablePrefix}"+tableName)
		        			.replace("into "+tableName, "into ${tablePrefix}"+tableName).
		        			replace("update "+tableName, "update ${tablePrefix}"+tableName);
		        }
		        p = Pattern.compile("update id=\"updateByExampleSelective\" parameterType=\"map\" >\\s+update \\$\\{tablePrefix\\}");
		        m = p.matcher(newStr);
		        if(m.find()){
		        	String group = m.group();
		        	newStr = newStr.replace(group, group.replace("${tablePrefix}", "${record.tablePrefix}"));
		        }
		        p = Pattern.compile("update id=\"updateByExample\" parameterType=\"map\" >\\s+update \\$\\{tablePrefix\\}");
		        m = p.matcher(newStr);
		        if(m.find()){
		        	String group = m.group();
		        	newStr = newStr.replace(group, group.replace("${tablePrefix}", "${record.tablePrefix}"));
		        }
		        p = Pattern.compile("select id=\"selectByPrimaryKey\" resultMap=\"BaseResultMap\" parameterType=\"\\S+\"");
		        m = p.matcher(newStr);
		        if(m.find()){
		        	String group = m.group();
		        	String groupArray[] = group.split("=");
		        	newStr = newStr.replace(group, group.replace(groupArray[groupArray.length-1], "\"map\""));
		        }
		        p = Pattern.compile("delete id=\"deleteByPrimaryKey\" parameterType=\"\\S+\"");
		        m = p.matcher(newStr);
		        if(m.find()){
		        	String group = m.group();
		        	String groupArray[] = group.split("=");
		        	newStr = newStr.replace(group, group.replace(groupArray[groupArray.length-1], "\"map\""));
		        }
		        System.out.println(file.toString());
		        PrintWriter printWriter = new PrintWriter(file);//替换后输出的文件位置
				printWriter.write(newStr);
				printWriter.flush();
				printWriter.close();
			}
		}
		System.out.println("\n\n-------------xml修改完毕-------------------\n\n");
	}
}
