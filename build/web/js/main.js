window.onload = function() {
  setup();
};

function setup() {
  for (var i = 0; i < document.forms.length; i++)
    ajaxForm("#" + document.forms[i].id);
  try {
    pageInit();
  } catch(e) {}
}

function addEvent(el, ev, cb) {
  var element = document.querySelector(el);
  if (element !== null)
    element[ev] = cb;
}

function ajaxForm(f) {
    addEvent(f, "onsubmit", onGeneralSubmit);
}

function onGeneralSubmit(e) {
  var data = e.target.serialize(true);
  var log = document.querySelector("#" + e.target.id + "_status");
  if (log === null)
      log = document.createElement("div");
  log.style.visibility = "visible";
  data.AJAX = true;
  console.log("Sending to " + e.target.action);
  new Ajax.Request(e.target.action, {
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
