package map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 13:27
 * @Description:
 */
public class MapMainTest {

    public static void main(String[] args) {
        Map<String, Object> model = new HashMap<>(2);
        model.put("name", "李永发");
        model.put("age", 22);
        User user = MapUtils.mapToObject(model, User.class);
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.NO_CLASS_NAME_STYLE));
        Map<String, Object> map = MapUtils.objectToMap(user);
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
    }
}
