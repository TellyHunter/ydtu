package com.util.alipay.config;

public class AlipayWapConfig {
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		// 合作身份者ID，以2088开头由16位纯数字组成的字符串
		public static String partner = "2088021087416333";
		
		// 收款支付宝账号，以2088开头由16位纯数字组成的字符串
		public static String seller_id = partner;
		// 商户的私钥
		public static String private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAOTwKmcSeNO4u2LRZb9EUG29m75/pSci71uuUhZF3uFpnkacICqzBIsiyoSz0bKaeaPvw51HUQjJHwseXDl1ldWEvxBvVy26J/8nWjlZwyeSZc4aYFbelXV4KQbohVz738LJBKoMmIG8xG6S39QY3jnu315e4H0cRHH42RDRJYK3AgMBAAECgYEAnuQkucazP1aOD2Z/dIEIRTH8nvleeUwgzgOtizHRH6c7J4yCMsBuXda2seVPm+Lkm6fznvv5PNzBg+j9Xw/B/c/aYiLsZxLeWFsZSaxLvq+ENIl8sVrHDAvCutLvwb6Zfpm5ZTPjSei/LhHN0y1PwiSRYLAPSDQLQwGW7Q6JjwECQQD6PMKQK4QbFOU1uFdnisoNbWuaS91OIdMlGRkyMJu3mCdCVsW6wigqx/+qF/PYbQugrzKvFvX3Hf09H5D/QBiBAkEA6jXW0OwnVm2/kxSCJoJ7yszg1VF2lwSABA9eOmCXyN+ysj9WRGfUWZF1YcEn7p0Ya8i6XY2nQJiyj2to3Bi/NwJBAOuEmFJ8wn+CsSBYeds4I2dz3tyAHrBU4Zd/AdndKhIoIHstlDhsWMW7KwP6O0UtjM4VVwy3/ZQyI5CNzziOKQECQQCMsJrCFZnryTFzYLZt+6PxRvEoMy9RuFpOFg08dBm5iOcHPBTOMrDUvRQODMG4DJZG6OVKnXUC0LcygAsVa6gxAkA1HMU9HChytObQGw5CPdm6e1FuclVWswFifHhWCULxEVPHbq7NTHfCZwGpQ0wJy98W1swrQy8BPoTBgN7VyySH";
		// 支付宝的公钥，无需修改该值
		public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

		//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		

		// 调试用，创建TXT日志文件夹路径
		public static String log_path = "D:\\";

		// 字符编码格式 目前支持 gbk 或 utf-8
		public static String input_charset = "utf-8";
		
		// 签名方式 不需修改
		public static String sign_type = "RSA";

}
