package com.dant.dao;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

class MemcacheInit {
	
	public static MemcachedClient getInstance() {
		return Init.mcc;
	}

	private static class Init {
		
		private final static MemcachedClient mcc = init();		

		private static MemcachedClient init() {
			System.out.println("init memcache");
			 try {
				return new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			} catch (IOException e) {
				e.printStackTrace();
			}
			 return null;
		}
	}
	
	

}
