
package com.github.ronnieren;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


enum PinyinType {
    HanYuPinYinWithoutToneNumber,
    HanYuPinYin,
    GwoYeuRomatzyh,
    MPS2PinYin,
    TongyongPinYin,
    WadeGilesPinYin,
    YalePinYin
}

public class RNPinyin4jModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNPinyin4jModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }


    @Override
    public String getName() {
        return "RNPinyin4j";
    }

    @ReactMethod
    public void getHanyuPinyinStringArray(final String chinese,  final Promise promise){
        getPinyinStringArray(PinyinType.HanYuPinYinWithoutToneNumber, chinese, promise);
    }

    @ReactMethod
    public void getHanyuPinyinStringArrayWithToneNumber(final String chinese,  final Promise promise){
        getPinyinStringArray(PinyinType.HanYuPinYin, chinese, promise);
    }

    @ReactMethod
    public void getGwoyeuRomatzyhStringArray(final String chinese,  final Promise promise){
        getPinyinStringArray(PinyinType.GwoYeuRomatzyh, chinese, promise);
    }

    @ReactMethod
    public void getMPS2PinYinStringArray(final String chinese,  final Promise promise){
        getPinyinStringArray(PinyinType.MPS2PinYin, chinese, promise);
    }

    @ReactMethod
    public void getWadeGilesPinYinStringArray(final String chinese,  final Promise promise){
        getPinyinStringArray(PinyinType.WadeGilesPinYin, chinese, promise);
    }

    @ReactMethod
    public void getYalePinYinStringArray(final String chinese,  final Promise promise){
        getPinyinStringArray(PinyinType.YalePinYin, chinese, promise);
    }


    @ReactMethod
    public void getTongyongPinYinStringArray(final String chinese,  final Promise promise){
        getPinyinStringArray(PinyinType.GwoYeuRomatzyh, chinese, promise);
    }

    void getPinyinStringArray(final PinyinType pinyinType, final String chinese,  final Promise promise){
        if(chinese.isEmpty()){
            promise.reject("error", "empty string");
            return;
        }

        String[] pinYins = new String[0];
        switch (pinyinType){

            case HanYuPinYinWithoutToneNumber:
                HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
                try {
                    pinYins = PinyinHelper.toHanyuPinyinStringArray(chinese.charAt(0), format);
                }
                catch (BadHanyuPinyinOutputFormatCombination e){

                }
                break;
            case HanYuPinYin:
                pinYins = PinyinHelper.toHanyuPinyinStringArray(chinese.charAt(0));
                break;
            case GwoYeuRomatzyh:
                pinYins = PinyinHelper.toGwoyeuRomatzyhStringArray(chinese.charAt(0));
                break;
            case MPS2PinYin:
                pinYins = PinyinHelper.toMPS2PinyinStringArray(chinese.charAt(0));
                break;
            case YalePinYin:
                pinYins = PinyinHelper.toYalePinyinStringArray(chinese.charAt(0));
                break;
            case WadeGilesPinYin:
                pinYins = PinyinHelper.toWadeGilesPinyinStringArray(chinese.charAt(0));
                break;
            case TongyongPinYin:
                pinYins = PinyinHelper.toTongyongPinyinStringArray(chinese.charAt(0));
                break;
        }


        if(pinYins.length > 0) {
            promise.resolve(pinYins[0]);
        }
        else {
            promise.reject("error", "fail to query the pinyin for " + chinese);
        }
    }

}