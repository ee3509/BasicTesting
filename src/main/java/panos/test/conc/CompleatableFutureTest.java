/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test.conc;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompleatableFutureTest
{
  public static void main(String[] args) {

    CompleatableFutureTest test = new CompleatableFutureTest();

    test.start();

  }


  public void start() {

    ArrayList<Future> list = new ArrayList<>();
    ArrayList<Future> nextList = new ArrayList<>();

    for (int i = 0; i < 50; i++) {
      list.add(startTask());
    }



    list.forEach(future -> {
      try {
        Object result = future.get();
        System.out.println("future.get() = " + result);
        nextList.add(nextTask((Long) result));


      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    });



  }

  private Future startTask() {
    CompletableFuture future = CompletableFuture.supplyAsync(() -> {
      try {
        System.out.println("Starting execution : " + this);
        long timeout = (long) (Math.random() * 2000);
        Thread.sleep(timeout);
        return timeout;
      } catch (InterruptedException e) {
        e.printStackTrace();
        return -1;
      }
    });
//    }, Executors.newSingleThreadExecutor()).

    return future;
  }

  private Future nextTask(long previousResult) {

    CompletableFuture future = CompletableFuture.supplyAsync(() -> {
      try {
        System.out.println(String.format("Previous Result : %s", previousResult ));
        long timeout = (long) (Math.random() * previousResult);
        Thread.sleep(timeout);
        return timeout;
      } catch (InterruptedException e) {
        e.printStackTrace();
        return -1;
      }
    });

    return future;

  }


}
