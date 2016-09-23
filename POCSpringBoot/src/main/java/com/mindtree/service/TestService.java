package com.mindtree.service;

import java.util.concurrent.Future;

public interface TestService {
 public String asyncMethod();
 public Future<Boolean> asyncFutureMethod();
 public void readData();
}
