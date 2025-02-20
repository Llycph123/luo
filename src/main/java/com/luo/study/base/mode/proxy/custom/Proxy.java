package com.luo.study.base.mode.proxy.custom;

import org.apache.commons.io.FileUtils;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luolingyan
 * @create 2025-02-19 14:29
 */
public class Proxy {
    public static Object newProxyInstance(Class itface, InvocationHandler h) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //声明一段源码
        String rt = "\r\n";

        String methodStr = "";
        for(Method m:itface.getMethods()){
            methodStr = "    @Override"+ rt +
                        "    public void "+ m.getName() +"() {"+ rt +
                        "        try{"+ rt +
                        "        Method md = "+ itface.getName() +".class.getMethod(\""+m.getName()+ "\");"+ rt +
                        "        h.invoke(this, md);"+ rt +
                        "        }catch(Exception e){e.printStackTrace();}"+ rt +
                        "    }";
        }

        String str =
        "package com.luo.study.base.mode.proxy.custom;"+ rt +
        "import java.lang.reflect.Method;"+ rt +
        "public class $Proxy0 implements "+ itface.getName() +"{"+ rt +
        "    private InvocationHandler h;"+ rt +
        "    public $Proxy0(InvocationHandler h){"+ rt +
        "        this.h = h;"+ rt +
        "    }"+ rt +
        methodStr + rt +
        "}";

        //产生代理类的java文件
        String filename = System.getProperty("user.dir")+"/src/main/java/com/luo/study/mode/proxy/custom/$Proxy0.java";
        File file = new File(filename);
        try {
            FileUtils.writeStringToFile(file, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //编译，拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        //获取文件
        Iterable units = fileManager.getJavaFileObjects(filename);
        //编译任务
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
        //进行编译
        t.call();
        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //load到内存
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("com.luo.study.base.mode.proxy.custom.$Proxy0");
        Constructor constructor = c.getConstructor(InvocationHandler.class);
        return constructor.newInstance(h);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        MoveAble m = (MoveAble) Proxy.newProxyInstance(MoveAble.class, h);
        m.move();
    }
}
