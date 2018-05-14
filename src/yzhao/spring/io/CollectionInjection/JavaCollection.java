package yzhao.spring.io.CollectionInjection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {
    private List addressList;
    private Set addressSet;
    private Map addressMap;
    private Properties addressProp;

    public JavaCollection(){

    }

    public JavaCollection(List addressList, Set addressSet, Map addressMap, Properties addressProp){
        System.out.println("JavaCollection constractor...");
        this.addressList = addressList;
        this.addressMap = addressMap;
        this.addressSet = addressSet;
        this.addressProp = addressProp;
    }

    public List getAddressList() {
        System.out.println("List: " + addressList);
        return addressList;
    }

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public Map getAddressMap() {
        System.out.println("Map: " + addressMap);
        return addressMap;
    }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        System.out.println("Properies: " + addressProp);
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    public Set getAddressSet() {
        System.out.println("Set: " + addressSet);
        return addressSet;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }
}
