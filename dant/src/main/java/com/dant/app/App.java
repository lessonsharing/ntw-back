package com.dant.app;

import com.dant.dao.JDBCCalls;
import com.dant.dao.MemcacheDAO;
import com.dant.entity.Session;
import com.dant.exception.RuntimeExceptionMapper;
import com.dant.filter.GsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pitton on 2017-02-20.
 */
@ApplicationPath("")
public class App extends Application {

	JDBCCalls jdbc = new JDBCCalls();
	@Override
	public Set<Object> getSingletons() {
		Set<Object> sets = new HashSet<>(1);
		sets.add(new API());
		return sets;
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> sets = new HashSet<>(1);
		sets.add(GsonProvider.class);
		sets.add(RuntimeExceptionMapper.class);
		return sets;
	}


}