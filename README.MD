# openapi sdk
封装了http请求调用，签名，加解密等

* 调用例子
```java
        //必填
        String apiUrl = "http://localhost:8082/gateway";
        //必填
        String appKey = "";
        //必填
        String appSecret = "";
        //如果开启加密，则必填
        String encodingAesKey = "";
        Client client = new Client(apiUrl,appKey,appSecret,encodingAesKey);
        //入参赋值
        List bodyList = new ArrayList<>();
        //根据接口 传入相应入参,这里只是个例子
        bodyList.add(1);
        //X-Service-Id对应的值
        String serviceId = "xxxx";
        //X-Service-Method对应的值
        String method = "xxxxxxx";
        Request request=new Request(serviceId,method,bodyList);
        Response response = client.execute(request);
        System.out.println(JSONUtils.toString(response));
        if(response.isSuccess()) {
            JSONResponseBean result = response.getJsonResponseBean();
            System.out.println(JSONUtils.toString(result));
        }else {
            System.out.println(response.getCaErrorMsg());
            System.out.println(response.getErrorMessage());
        }
```

[使用postman进行接口调试](https://github.com/ngarihealth/openapi-sdk-java/wiki/使用postman进行接口调试)
