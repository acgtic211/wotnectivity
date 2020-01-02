package es.ual.acg;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public interface IRequester{

    CompletableFuture<?> sendRequest(String address, HashMap<String, Object> configuration, Object payload);

}