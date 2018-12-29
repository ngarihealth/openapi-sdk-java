package ngari;

import ngari.openapi.Client;
import ngari.openapi.JSONResponseBean;
import ngari.openapi.Request;
import ngari.openapi.Response;
import ngari.openapi.request.province.DoctorBussReq;
import ngari.openapi.request.province.DoctorIndicatorsReq;
import ngari.openapi.util.JSONUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
    @Test
    public void post() throws Exception {
        //必填
        String apiUrl = "http://172.16.20.250:8099/ehealth-openapi-feature2/gateway";
        //必填
        String appKey = "zxq";
        //必填
        String appSecret = "zxqzxqzxqzxqzxqzxqzxq";
        //如果开启加密，则必填
        String encodingAesKey = "1234567890123456";
        Client client = new Client(apiUrl,appKey,appSecret,encodingAesKey);

        //调用相应的接口请求
        Response response = client.execute(getDoctorBussReq());
        System.out.println(JSONUtils.toString(response));
        if(response.isSuccess()) {
            //接口返回的结果
            JSONResponseBean result = response.getJsonResponseBean();
            System.out.println(JSONUtils.toString(result));
        }else {
            System.out.println(response.getCaErrorMsg());
            System.out.println(response.getErrorMessage());
        }

    }
    private Request getDoctorBussReq(){
        //入参赋值,注意最外层是个json数组
        List bodyList = new ArrayList<>();
        //根据接口 传入相应入参,这里只是个例子
        DoctorBussReq req=new DoctorBussReq();
        req.setDoctorID("1101");
        req.setDoctorName("test");
        req.setApplyDate(new Date());
        req.setOrganID("1");
        req.setBusinessType("");
        req.setUnitID("");
        req.setOrganName("");
        bodyList.add(req);
        //X-Service-Id对应的值
        String serviceId = "his.provinceDataUploadService";
        //X-Service-Method对应的值
        String method = "openDoctorBusiness";
        return new Request(serviceId,method,bodyList);
    }
    private Request getDoctorIndicatorsReq(){
        //入参赋值,注意最外层是个json数组
        List bodyList = new ArrayList<>();
        //根据接口 传入相应入参,这里只是个例子
        List<DoctorIndicatorsReq> doctorList = new ArrayList<>();
        DoctorIndicatorsReq req=new DoctorIndicatorsReq();
        req.setDoctorID("1101");
        req.setDoctorName("test");
        req.setOrganID("1");
        req.setUnitID("");
        req.setOrganName("");
        doctorList.add(req);
        bodyList.add(req);
        //X-Service-Id对应的值
        String serviceId = "his.provinceDataUploadService";
        //X-Service-Method对应的值
        String method = "openDoctorBusiness";
        return new Request(serviceId,method,bodyList);
    }
}
