package com.springguild.gateway.util;

import org.springframework.web.context.request.async.*;
import rx.*;

/**
 * Created by jamesliljenquist on 9/7/15.
 */
public class AsyncUtil {

	public static <T> DeferredResult<T> toDeferredResult(Observable<T> observable) {

		final DeferredResult<T> result = new DeferredResult<T>();

		observable.subscribe(new Observer<T>() {
			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable throwable) {
				result.setErrorResult(throwable);
			}

			@Override
			public void onNext(T observableResult) {
				result.setResult(observableResult);
			}
		});

		return result;
	}
}
