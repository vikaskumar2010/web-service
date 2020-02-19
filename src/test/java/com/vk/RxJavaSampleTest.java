package com.vk;

import org.testng.annotations.Test;

import rx.*;

public class RxJavaSampleTest {

  Subscriber<Integer> s1 = new Subscriber<Integer>() {

    @Override
    public void onCompleted() {
      System.out.println("Completed");

    }

    @Override
    public void onError(Throwable e) {
      System.out.println("Error occured.." + e);

    }

    @Override
    public void onNext(Integer t) {
      System.out.println("Recieved=" + t);

    }
  };

  @Test
  public void test() {
    Observable<Integer> o = Observable.range(1, 50);



    o.subscribe(s1);


  }
}
