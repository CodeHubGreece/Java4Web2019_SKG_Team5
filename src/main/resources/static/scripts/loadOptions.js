// function loadSpecialities() {
//     let speciality = document.getElementById("speciality");
//     let options;
//     //let password = passwordElement && passwordElement.value ? passwordElement.value : "";
//
//     //let fd = new FormData();
//     //fd.append( 'username', username);
//     //fd.append( 'password', password);
//     var helpers =
//         {
//             buildDropdown: function(result, dropdown, emptyMessage)
//             {
//                 // Remove current options
//                 dropdown.html('');
//                 // Add the empty option with the empty message
//                 dropdown.append('<option value="">' + emptyMessage + '</option>');
//                 // Check result isnt empty
//                 if(result != '')
//                 {
//                     // Loop through each of the results and append the option to the dropdown
//                     $.each(result, function(k, v) {
//                         dropdown.append('<option value="' + v.id + '">' + v.name + '</option>');
//                     });
//                 }
//             }
//         }
//     $.ajax({
//         url: ROOT_PATH + '/login',
//         data: fd,
//         processData: false,
//         contentType: false,
//         type: 'GET',
//         success: function(data)
//         {
//             helpers.buildDropdown(
//                 jQuery.parseJSON(data),
//                 $(options),
//                 'Select an option'
//             );
//         },
//         statusCode: {
//             401 : function() {
//                 alert("Invalid username or password!");
//             }
//         }
//     });
// }

