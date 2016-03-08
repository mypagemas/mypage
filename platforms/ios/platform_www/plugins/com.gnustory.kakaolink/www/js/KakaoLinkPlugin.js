cordova.define("com.gnustory.kakaolink.KakaoLinkPlugin", function(require, exports, module) { /**
 * Created by gnustory on 2014. 8. 27..
 */
function KakaoLinkPlugin() {}
KakaoLinkPlugin.prototype.call = function(message, buttonTitle, webLink) {
    if(!message) message = '';
    if(!buttonTitle) buttonTitle = '';
    if(!webLink) webLink = '';
    cordova.exec(null, null, "KakaoLinkPlugin", "call", [message, buttonTitle, webLink]);
};

module.exports = new KakaoLinkPlugin();
});
