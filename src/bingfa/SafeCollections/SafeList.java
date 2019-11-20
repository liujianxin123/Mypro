package bingfa.SafeCollections;

import java.util.*;

public class SafeList {
    public void safelist(){

        List list = Collections.synchronizedList(new ArrayList());
        Set set = Collections.synchronizedSet(new HashSet());
        Map map = Collections.synchronizedMap(new HashMap());

    }
}
