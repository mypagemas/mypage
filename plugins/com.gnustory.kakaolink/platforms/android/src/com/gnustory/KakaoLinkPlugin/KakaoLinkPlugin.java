package com.gnustory.KakaoLinkPlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;

public class KakaoLinkPlugin extends CordovaPlugin {
    private final String ACTION_CALL = "call";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(ACTION_CALL)) {
            String message = args.getString(0);
            try {
				this.call(message, callbackContext);
			} catch (KakaoParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//            this.call(message, callbackContext);
            
            return true;
        }
        return false;
    }

    private void call(String message, CallbackContext callbackContext) throws KakaoParameterException {
        if (message != null && message.length() > 0) {
        	
        	final KakaoLink kakaoLink = KakaoLink.getKakaoLink(this.cordova.getActivity());
        	final KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
			kakaoTalkLinkMessageBuilder.addText(message);
			kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder.build(), this.cordova.getActivity());
			
        	callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, message));
        	callbackContext.success(message);
        	
        } else {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "Expected one non-empty string argument."));
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

}