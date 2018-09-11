package chihane.jdaddressselector;

import android.content.Context;


import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

public class DefaultAddressProvider implements AddressProvider {
    public DefaultAddressProvider(Context context) {

    }

    @Override
    public void provideProvinces(final AddressReceiver<Province> addressReceiver) {

    }

    @Override
    public void provideCitiesWith(int provinceId,String provinceIdStr, final AddressReceiver<City> addressReceiver) {

    }

    @Override
    public void provideCountiesWith(int cityId,String cityIdStr, final AddressReceiver<County> addressReceiver) {

    }

    @Override
    public void provideStreetsWith(int countyId,String countyIdStr, final AddressReceiver<Street> addressReceiver) {

    }
}
