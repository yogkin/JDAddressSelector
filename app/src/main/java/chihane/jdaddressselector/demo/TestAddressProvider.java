package chihane.jdaddressselector.demo;

import java.util.Collections;

import chihane.jdaddressselector.AddressProvider;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

public class TestAddressProvider implements AddressProvider {


    @Override
    public void provideProvinces(AddressReceiver<Province> addressReceiver) {

    }

    @Override
    public void provideCitiesWith(int provinceId, String provinceIdStr, AddressReceiver<City> addressReceiver) {

    }

    @Override
    public void provideCountiesWith(int cityId, String cityIdStr, AddressReceiver<County> addressReceiver) {

    }

    @Override
    public void provideStreetsWith(int countyId, String countyIdStr, AddressReceiver<Street> addressReceiver) {

    }
}
