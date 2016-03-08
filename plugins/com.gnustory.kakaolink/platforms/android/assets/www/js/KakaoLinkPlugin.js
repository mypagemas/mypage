/**
 * Created by gnustory on 2014. 8. 27..
 */
function KakaoLinkPlugin() {}
KakaoLinkPlugin.prototype.call = function(message) {
    cordova.exec(null, null, "KakaoLinkPlugin", "call", [message]);
};

module.exports = new KakaoLinkPlugin();