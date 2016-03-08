cordova_plugin-KakaoLinkPlugin
==============

##Text type

        
###*Usage*
        KakaoLinkPlugin.call("kakaotalk share...");


##Api import

###*common* 
Create kakao App [Kakao Developers](https://developers.kakao.com/apps).


###*iOS setting*
        cordova create myApp
                
        cd myApp/
        
        cordova platform add ios
        
        cordova -d plugin add https://github.com/gnustory/cordova_plugin-KakaoLinkPlugin.git --variable APP_KEY="e8aa9b80eb803ab5ca55a22b2d0ff46b";
        
        open platforms/ios/*.xcodeproj
            Build Settings > Linking > Other Linker Flags > add '-all_load'
        
        cordova build ios
        
###*Android setting*
        cordova create myApp
        
        cd myApp/
        
        cordova platform add android
        
        cordova -d plugin add https://github.com/gnustory/cordova_plugin-KakaoLinkPlugin.git --variable APP_KEY="e8aa9b80eb803ab5ca55a22b2d0ff46b";
                
            'platforms/android/local.properties' copy to 'platforms/android/KakaoLib' directory.
            'platforms/android/local.properties' copy to 'platforms/android/google-play-services_lib' directory.
            'platforms/android/CordovaLib/build.xml' copy to 'platforms/android/KakaoLib' directory.
            'platforms/android/CordovaLib/build.xml' copy to 'platforms/android/google-play-services_lib' directory.
            
        android update project --subprojects --path "platforms/android" --target android-19 --library "KakaoLib"
        
        cd platforms/android/
        ant clean
        
        cd KakaoLib
        ant clean
        
        cd ../google-play-services_lib
        ant clean
        
        ant release
        
        cd ../../..
        
        cordova build android