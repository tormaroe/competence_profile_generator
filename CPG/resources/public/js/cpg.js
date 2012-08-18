
window.document.cpg = (function () {
  var saveData = function(key, value, success) {
    $.post("/save-data", { key: key, value: value })
      .success(success)
      .error(function() { alert("error saving data"); });
  };

  var confirmThenPostThenGoto = function(args) {
    if(confirm(args.message)) {
      $.post(args.post, args.data)
        .success(function() {
          document.location = args.success;
        })
        .error(function() { alert(args.error); });
     }
  };
        


  return {
    updateData: function(key, inputField) {
                  saveData(key, document.getElementById(inputField).value, function() { });
                },
    addNewDataField: function() {
                       var key = prompt("Type in the new key (NO SPACES PLEASE)", ""),
                           value = prompt("And now type in the value", "");
                       saveData(key, value, function() {
                          document.location = "/manage-data";
                       });
                     },
    deleteData: function(key) {
                  confirmThenPostThenGoto({
                    message: "ARE YOU SURE YOU WANT TO DELETE THIS KEY?\nIf it's is use this will mess up the profile generation..",
                    post: "/delete-data", 
                    data: {key: key},
                    success: "/manage-data",
                    error: "error deleting data"
                  });
                },
    deleteGroup: function(key) {
                   confirmThenPostThenGoto({
                     message: "ARE YOU SURE? You will lose access to any text snippets in this group.\nYou may fix this however by creating it again with the exact same name.",
                     post: "/delete-group", 
                     data: {key: key},
                     success: "/manage-groups",
                     error: "error deleting group"
                   });
                 }
  };
})();
