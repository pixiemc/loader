package rip.pixie;

import net.bytebuddy.agent.ByteBuddyAgent;
import org.objectweb.asm.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class EssentialTransformer {
    private static class Transformer implements ClassFileTransformer {
        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            if (!className.equals("gg/essential/network/connectionmanager/Connection")) {
                return null;
            }

            ClassReader reader = new ClassReader(classfileBuffer);
            ClassWriter writer = new ClassWriter(reader, 0);

            reader.accept(new ClassVisitor(Opcodes.ASM9, writer) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                    if (!name.equals("<init>")) {
                        return super.visitMethod(access, name, descriptor, signature, exceptions);
                    }
                    return new MethodVisitor(Opcodes.ASM9, super.visitMethod(access, name, descriptor, signature, exceptions)) {
                        @Override
                        public void visitLdcInsn(Object value) {
                            if (value.equals("wss://connect.essential.gg/v1")) {
                                super.visitLdcInsn("wss://connect.pixie.rip/v1");
                            } else {
                                super.visitLdcInsn(value);
                            }
                        }
                    };
                }
            }, 0);

            return writer.toByteArray();
        }
    }

    public static void transform() {
        // TODO: Make this a logger
        System.out.println("[pixie-loader] Pixie is injecting into Essential! (You can safely ignore the below warning)");
        Instrumentation instrumentation = ByteBuddyAgent.install();
        instrumentation.addTransformer(new Transformer(), true);
    }
}