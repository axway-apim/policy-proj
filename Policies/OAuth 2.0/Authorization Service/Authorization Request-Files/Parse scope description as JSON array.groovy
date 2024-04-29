import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vordel.trace.Trace;
import com.vordel.kps.Store;
import com.vordel.kps.impl.KPS;
import com.vordel.kps.Transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.transform.Field

@Field
def mapper = new ObjectMapper();

def invoke(msg) {
    Store store = KPS.getInstance().getStore("scopesDes");
    Transaction transaction = store.beginTransaction();
    List<Object> list = new ArrayList<>();
    try {

        for (Map<String, Object> map : transaction) {
            list.add(map);
        }
    } finally {
        transaction.close();
    }
    def arrNode = mapper.valueToTree(list);
    msg.put("oauth.scopeDes", arrNode);
    return true;
}