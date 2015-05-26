function pageInit() {
    var subscriptions = document.querySelectorAll(".subscription");
    for (var i = 0; i < subscriptions.length; i++) {
        var sub = subscriptions[i];
        sub.querySelector(".cancel").onclick = removeSubscription;
    }
}

function removeSubscription(sub) {
  var data = {subscription: sub.target.parentElement.getAttribute("x-id")};
  var log = document.createElement("div");
  log.style.visibility = "visible";
  data.AJAX = true;
  console.log("Sending to removesubscription");
  new Ajax.Request("removesubscription", {
    method: 'POST',
    parameters: data,
    onSuccess: function(ret_) {
      var ret = ret_.responseJSON;
      console.log(ret_);
      if (ret.success) {
        document.location = ret.redirect;
      } else {
        log.innerHTML = ret.error;
        log.classList.add("error_msg");
      }
    },
    onFailure: function() {
      log.innerHTML = "An error occurred, please try again.";
      log.classList.add("error_msg");
    }
  });
  return false;
}