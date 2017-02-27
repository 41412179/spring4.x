package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class MyComponent {

    //Spring会将容器中所有类型为Plugin的Bean注入到这个变量中
    @Autowired(required = false)
    private List<Plugin> plugins;

    //将Plugin类型的Bea注入到Map中，其中key是Bean的名字，value是所有实现了Plugin接口的Bean
    @Autowired
    private Map<String, Plugin> pluginMap;

    public List<Plugin> getPlugins() {
        return plugins;
    }

    public Map<String, Plugin> getPluginMap() {
        return pluginMap;
    }
}
