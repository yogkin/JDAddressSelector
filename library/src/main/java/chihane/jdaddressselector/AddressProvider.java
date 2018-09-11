package chihane.jdaddressselector;

import java.util.List;

import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

public interface AddressProvider {
    void provideProvinces(AddressReceiver<Province> addressReceiver);
    void provideCitiesWith(int provinceId,String provinceIdStr, AddressReceiver<City> addressReceiver);
    void provideCountiesWith(int cityId,String cityIdStr, AddressReceiver<County> addressReceiver);
    void provideStreetsWith(int countyId,String countyIdStr, AddressReceiver<Street> addressReceiver);

    interface AddressReceiver<T> {
        void send(List<T> data);
    }
}