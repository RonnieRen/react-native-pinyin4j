
#import "RNPinyin4j.h"

#define REJECTORWITHERRORMSG(rejector, errorMsg)  NSError* er =  [NSError errorWithDomain: @"com.geerong.www" code:10000 userInfo:@{@"description": @#errorMsg}]; \
rejector([NSString stringWithFormat:@"%ld", er.code], er.localizedDescription, er);


@implementation RNPinyin4j

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()


RCT_EXPORT_METHOD(getHanyuPinyinStringArray: (NSString*)firstCharacter resolver: (RCTPromiseResolveBlock)resolver
                  rejecter:(RCTPromiseRejectBlock)reject ) {
    if(!firstCharacter){
        REJECTORWITHERRORMSG(reject, "nil value is not supported");
        return;
    }
    NSMutableString* str = [NSMutableString stringWithString:firstCharacter];
    CFStringTransform((CFMutableStringRef)str, NULL, kCFStringTransformToLatin, false);
    CFStringTransform((CFMutableStringRef)str, NULL, kCFStringTransformStripDiacritics, NO);
    resolver(@[str]);
}
@end

