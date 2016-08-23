package com.sigmatrix.sc.utils;


import java.io.File;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.sigmatrix.sc.exception.TimeOutException;


public class AmazonUtil {
	//private static Logger logger = Logger.getLogger("bigdata");
	private static String amazonDynamoDBEndpoint;
	private static String amazonAWSAccessKey;
	private static String amazonAWSSecretKey;
	private static String amazonS3Bucket;
	private String region;
	
	public static ValueFilter filter = new ValueFilter() {
		public Object process(Object obj, String s, Object v) {
			if (v == null || v.equals("")) {
				return null;
			}
			return v;
		}
	};
	
	public AmazonDynamoDBClient createClient() {
		AWSCredentials credentials = new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
		AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials);
		client.setEndpoint(amazonDynamoDBEndpoint);
//		Region cnNorth = Region.getRegion(Regions.CN_NORTH_1);
//		client.setRegion(cnNorth);
		// 替代上面两句
		client.setSignerRegionOverride(region);
		return client;

	}

	public DynamoDBMapper getDynamoDBMapper() {
		DynamoDBMapper mapper = new DynamoDBMapper(createClient());
		return mapper;
	}

	public DynamoDB getDynamoDB() {
		DynamoDB db = new DynamoDB(createClient());

		return db;
	}

	public AmazonS3 createS3Client() {
		AWSCredentials credentials = new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
		AmazonS3 s3client = new AmazonS3Client(credentials);
		s3client.setEndpoint(amazonDynamoDBEndpoint);
		Region usWest2 = Region.getRegion(Regions.CN_NORTH_1);
		s3client.setRegion(usWest2);
		return s3client;
	}

	/**
	 * 公开化上传文件
	 * @param key
	 * @param file
	 * @throws Exception
	 */
	public void savePublicFile(String key, File file) throws Exception {
		AccessControlList acl = new AccessControlList();
		acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
		// 注意：这里的amazonS3Bucket类似于："henanyanjing/dev"，最后面不能带"/",否则上传时会在dev后新建一个空目录
		createS3Client().putObject(new PutObjectRequest(amazonS3Bucket, key, file).withAccessControlList(acl));
		
	}
	/**
	 * 私有化上传文件
	 * @param key
	 * @param file
	 * @throws Exception
	 */
	public void savePrivateFile(String key, File file) throws Exception {
		createS3Client().putObject(new PutObjectRequest(amazonS3Bucket, key, file));
		
	}

	/**
	 * 超过100M文件分段上传方法
	 * @param key
	 * @param file
	 * @throws Exception
	 */
	public void saveSubsectionFile(String key, File file) throws Exception {
		System.out.println("Upload file start");
		TransferManager tm = new TransferManager(createS3Client());        
        
        try {
        	Upload upload = tm.upload(amazonS3Bucket, key, file);
        	upload.waitForCompletion();
		} catch (AmazonClientException amazonClientException) {
        	System.out.println("Unable to upload file, upload was aborted.");
        	amazonClientException.printStackTrace();
        	throw new TimeOutException(amazonClientException.getMessage());
        }finally{
        	tm.shutdownNow();
        	System.out.println("Upload file shutdown");
        }
	}
	
	public String getAmazonDynamoDBEndpoint() {
		return amazonDynamoDBEndpoint;
	}

	public void setAmazonDynamoDBEndpoint(String amazonDynamoDBEndpoint) {
		this.amazonDynamoDBEndpoint = amazonDynamoDBEndpoint;
	}

	public String getAmazonAWSAccessKey() {
		return amazonAWSAccessKey;
	}

	public void setAmazonAWSAccessKey(String amazonAWSAccessKey) {
		this.amazonAWSAccessKey = amazonAWSAccessKey;
	}

	public String getAmazonAWSSecretKey() {
		return amazonAWSSecretKey;
	}

	public void setAmazonAWSSecretKey(String amazonAWSSecretKey) {
		this.amazonAWSSecretKey = amazonAWSSecretKey;
	}

	public String getAmazonS3Bucket() {
		return amazonS3Bucket;
	}

	public void setAmazonS3Bucket(String amazonS3Bucket) {
		this.amazonS3Bucket = amazonS3Bucket;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
