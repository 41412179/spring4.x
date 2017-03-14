package com.smart.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class Register {
    public void remain(String agentArgs, Instrumentation inst) {
        ClassFileTransformer t = new TransFormer();
        inst.addTransformer(t);
    }
}
