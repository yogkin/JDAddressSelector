package chihane.jdaddressselector.demo;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import chihane.jdaddressselector.AddressProvider;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

public class KmAddressProvider implements AddressProvider {
    @Override
    public void provideProvinces(final AddressReceiver<Province> addressReceiver) {
        OkGo.<String>post("http://api.123cx.cc/Address/GetProvinces")
                .headers("user_session", "2RHhFcnN")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        List<String> stringList = new ArrayList<>();
                        try {

                            JSONObject jsonObject = new JSONObject(response.body());
                            Iterator<String> keys = jsonObject.keys();
                            while (keys.hasNext()) {
                                stringList.add(keys.next());
                            }

                        } catch (JSONException e) {
                        }
                        ArrayList<Province> provinces = new ArrayList<>();
                        for (int i = 0; i < stringList.size(); i++) {
                            Province province = new Province();
                            province.name = stringList.get(i);
                            province.id = i;
                            province.idStr = stringList.get(i);
                            provinces.add(province);
                        }

                        addressReceiver.send(provinces);
                    }
                });
    }

    @Override
    public void provideCitiesWith(int provinceId,String provinceIdStr, final AddressReceiver<City> addressReceiver) {
        OkGo.<String>post("http://api.123cx.cc/Address/GetCities")
                .headers("user_session", "2RHhFcnN")
                .params("id", provinceIdStr)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        List<String> stringList = new ArrayList<>();
                        try {

                            JSONObject jsonObject = new JSONObject(response.body());
                            Iterator<String> keys = jsonObject.keys();
                            while (keys.hasNext()) {
                                stringList.add(keys.next());
                            }

                        } catch (JSONException e) {
                        }
                        ArrayList<City> citys = new ArrayList<>();
                        for (int i = 0; i < stringList.size(); i++) {
                            City city = new City();
                            city.name = stringList.get(i);
                            city.id = i;
                            city.idStr = stringList.get(i);
                            citys.add(city);
                        }

                        addressReceiver.send(citys);
                    }
                });
    }

    @Override
    public void provideCountiesWith(int cityId, String cityIdStr, final AddressReceiver<County> addressReceiver) {
        OkGo.<String>post("http://api.123cx.cc/Address/GetCounties")
                .headers("user_session", "2RHhFcnN")
                .params("id", cityIdStr)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        List<String> stringList = new ArrayList<>();
                        List<String> stringIdList = new ArrayList<>();
                        try {

                            JSONObject jsonObject = new JSONObject(response.body());
                            Iterator<String> keys = jsonObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                stringIdList.add(next);
                                stringList.add(jsonObject.getString(next));
                            }

                        } catch (JSONException e) {
                        }
                        ArrayList<County> counties = new ArrayList<>();
                        for (int i = 0; i < stringList.size(); i++) {
                            try{
                                County county = new County();
                                county.name = stringList.get(i);
                                county.id = Integer.parseInt(stringIdList.get(i));
                                county.idStr = i+"";
                                counties.add(county);
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                        }

                        addressReceiver.send(counties);
                    }
                });
    }

    @Override
    public void provideStreetsWith(int countyId,String countyIdStr, AddressReceiver<Street> addressReceiver) {

        Street street = new Street();
        street.id = countyId;
        addressReceiver.send(new ArrayList<Street>());

    }
}
