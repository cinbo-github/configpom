#include <stdio.h>
#include <stdlib.h>
#include "com_cinbo_testbean_TestJniMain.h"
#include "com_bayss_luminex_filetransfer_util_ClassEncryptUtil.h"
#include <jvmti.h>
#include <jni_md.h>
#include <string.h>

/**< 此处定义结构体GobalAgentData用于保存jvmtiEnv指针 */
typedef struct {
	jvmtiEnv* jvmti;
}GlobalAgentData;

static GlobalAgentData* gdata;

JNIEXPORT void JNICALL Java_com_cinbo_testbean_TestJniMain_HelloWord(JNIEnv * env, jclass obj){

  printf("hello word!/n");

}

JNIEXPORT jstring JNICALL Java_com_cinbo_testbean_TestJniMain_cToJava(JNIEnv * env, jclass obj){
	jstring jstr;

	char str[]="Hello,word!/n";

	jstr=env->NewStringUTF(str);

	return jstr;
}


void JNICALL
ClassFileLoadHook(jvmtiEnv* jvmti_env,
    JNIEnv* jni_env,
    jclass class_being_redefined,
    jobject loader,
    const char* name,
    jobject protection_domain,
    jint class_data_len,
    const unsigned char* class_data,
    jint* new_class_data_len,
    unsigned char** new_class_data) {

    printf("class file load %s\n", name);


}

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM* jvm, char* options, void* reserved) {

    jvmtiEnv* jvmti = NULL;
    jvmtiCapabilities capa;
    jvmtiError error;

    jint result = (*jvm).GetEnv((void**)&jvmti, JVMTI_VERSION_1_1);
    if (result != JNI_OK) {
        printf("ERROR : Unable to access JVMTI! \n");
    }

    (void)memset(&capa, 0, sizeof(jvmtiCapabilities));

    /**< can_tag_objects : can set and get tags, as described in the Heap category
     *  通过将capa_can_tag_objects设置为1，代表enable this capability
    */
    capa.can_tag_objects = 1;
    capa.can_generate_all_class_hook_events = 1;
    

    /** \jvmtiError AddCapabilities(jvmtiEnv* env, const jvmtiCapabilities* capabilities_ptr)
     *
     * 设置新的capabilities，之前的capabilities也会被保留
     *
     */
    error = (*jvmti).AddCapabilities(&capa);




    jvmtiEventCallbacks callbacks;
    (void)memset(&callbacks, 0, sizeof(callbacks));
    callbacks.ClassFileLoadHook = &ClassFileLoadHook;
    (*jvmti).SetEventCallbacks(&callbacks, sizeof(callbacks));
    
    (*jvmti).SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_CLASS_FILE_LOAD_HOOK, NULL);


        /**< store jvmtiEnv in a global data */
        gdata = (GlobalAgentData*)malloc(sizeof(GlobalAgentData));
        gdata->jvmti = jvmti;
        printf("jvmTI: vm started 2\n");
        return JNI_OK;
}

/*
* 文件加密解密的代码
*/

/*
 * Class:     com_bayss_luminex_filetransfer_util_ClassEncryptUtil
 * Method:    encryptData
 * Signature: ([BI[B)I
 */
JNIEXPORT jint JNICALL Java_com_bayss_luminex_filetransfer_util_ClassEncryptUtil_encryptData
(JNIEnv*, jclass, jbyteArray, jint, jbyteArray) {

}

/*
 * Class:     com_bayss_luminex_filetransfer_util_ClassEncryptUtil
 * Method:    decryptData
 * Signature: ([BI[B)I
 */
JNIEXPORT jint JNICALL Java_com_bayss_luminex_filetransfer_util_ClassEncryptUtil_decryptData
(JNIEnv*, jclass, jbyteArray, jint, jbyteArray) {

}