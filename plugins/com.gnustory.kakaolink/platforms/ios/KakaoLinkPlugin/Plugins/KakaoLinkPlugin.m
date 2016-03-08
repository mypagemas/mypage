//
//  KakaoLinkPlugin.m
//  KakaoTest
//
//  Created by GEUNWOO JANG on 2014. 8. 26..
//
//

#import "KakaoLinkPlugin.h"
#import <KakaoOpenSDK/KakaoOpenSDK.h>

@implementation KakaoLinkPlugin

- (void)call:(CDVInvokedUrlCommand *)command
{
    
    NSString* message = [command.arguments objectAtIndex:0];
    NSString* buttonTitle = [command.arguments objectAtIndex:1];
    NSString* webLink = [command.arguments objectAtIndex:2];
    
    KakaoTalkLinkObject *label
    = [KakaoTalkLinkObject createLabel:message];
    
    KakaoTalkLinkObject *button
    = [KakaoTalkLinkObject createWebButton:buttonTitle
                                       url:webLink];

    
    
    
    if ([message length] == 0){
        
        if([webLink length] != 0){
            //weblink만 있는 경우
            [KOAppCall openKakaoTalkAppLink:@[button]];
        }else{
            //message와 weblink 모두 없는 경우
        }
        
    }else{
        
        if([webLink length] == 0){
            //message만 있는 경우
            [KOAppCall openKakaoTalkAppLink:@[label]];
        }else{
            //message와 weblink가 모두 있는 경우
            [KOAppCall openKakaoTalkAppLink:@[label, button]];
        }
        
    }


    
    
}

@end
