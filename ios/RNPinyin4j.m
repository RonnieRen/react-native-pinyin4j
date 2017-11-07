
#import "RNPinyin4j.h"

@implementation RNPinyin4j

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()


RCT_EXPORT_METHOD(getHanyuPinyinStringArray: (NSString*)firstCharacter resolver: (RCTPromiseResolveBlock)resolver
                  rejecter:(RCTPromiseRejectBlock)reject ) {
    
    NSMutableString* str = [NSMutableString stringWithString:firstCharacter];
    CFStringTransform((CFMutableStringRef)str, NULL, kCFStringTransformToLatin, false);
    CFStringTransform((CFMutableStringRef)str, NULL, kCFStringTransformStripDiacritics, NO);
    resolver(@[str]);
}
@end
  
