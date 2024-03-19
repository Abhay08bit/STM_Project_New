function openModal(message) {
	const modal = document.getElementById('modal');
	const modalMessage = document.getElementById('modalMessage');
	modalMessage.textContent = message;
	modal.style.display = 'block';
}

function closeModal() {
	const modal = document.getElementById('modal');
	modal.style.display = 'none';
}

function openModal(modalId) {
	const modal = document.getElementById(modalId);
	modal.style.display = 'flex';
}

function closeModal(modalId) {
	const modal = document.getElementById(modalId);
	modal.style.display = 'none';
}

  function validateDate(input) {
    const dateInput = input.value;
    const dateArray = dateInput.split('/');
    
    if (dateArray.length === 3) {
        const year = parseInt(dateArray[0], 10);
        const month = parseInt(dateArray[1], 10);
        const day = parseInt(dateArray[2], 10);

        // Check if the month is valid
        if (month < 1 || month > 12) {
            openModal('modalErrorMonth');
            input.value = '';
            return;
        }

        // Check if the day is valid for the given month
        const daysInMonth = new Date(year, month, 0).getDate();
        if (day < 1 || day > daysInMonth) {
            openModal('modalErrorDay');
            input.value = '';
            return;
        }
    } else {
        openModal('modalErrorFormat');
        input.value = '';
        return;
    }
}


function formatInputDate(input) {
            let inputValue = input.value.replace(/\D/g, '');

            if (inputValue.length === 8) {
                const formattedDate = inputValue.replace(/(\d{4})(\d{2})(\d{2})/, '$1/$2/$3');
                input.value = formattedDate;
            }
        }

function updatePdfFileName(textInputId, fileInputId, errorElementId) {
	         const textInput = document.getElementById(textInputId);
	         const fileInput = document.getElementById(fileInputId);
	         const stmNo = document.getElementById('stmNumber').value;
	     	 const stmVersion = document.getElementById('disabledField').value;
	         //const errorElement = document.getElementById(errorElementId);

         if (!stmNo) {
           // stmNo is null or empty, clear file name and input field
           textInput.value = '';
           fileInput.value = '';
           closeModal(errorElementId);
           return;
           }

	         if (fileInput.files.length > 0) {
	             const fileName = fileInput.files[0].name;
	             const fileExtension = fileName.split('.').pop().toLowerCase();

	             if (fileExtension !== 'pdf') {
	                 textInput.value = '';
	                 fileInput.value = '';
	                 openModal(errorElementId);
	             } else {
	                 // Construct the new file name (STMStmNoRevisionNo.extension)
	                 const newFileName = "STM" + stmNo + stmVersion + "." + fileExtension;
	                 
	                 // Update the value of the text input
	                 textInput.value = newFileName;
	                 closeModal(errorElementId);
	             }
	         } else {
	             textInput.value = '';
	             fileInput.value = '';
	             closeModal(errorElementId);
	         }
	     }
	 function updateWordFileName(textInputId, fileInputId, errorElementId) {
	     const textInput = document.getElementById(textInputId);
	     const fileInput = document.getElementById(fileInputId);
	     const stmNo = document.getElementById('stmNumber').value;
	 	 const stmVersion = document.getElementById('disabledField').value;
	     //const errorElement = document.getElementById(errorElementId);
         if (!stmNo) {
        // stmNo is null or empty, clear file name and input field
          textInput.value = '';
          fileInput.value = '';
          closeModal(errorElementId);
          return;
         }

	     if (fileInput.files.length > 0) {
	         const fileName = fileInput.files[0].name;
	         const fileExtension = fileName.split('.').pop().toLowerCase();

	         if (fileExtension !== 'doc' && fileExtension !== 'docx') {
	             textInput.value = '';
	             fileInput.value = '';
	             openModal(errorElementId);
	         } else {
	             // Construct the new file name (STMStmNoRevisionNo.extension)
	             const newFileName = "STM" + stmNo + stmVersion + "." + fileExtension;
	             
	             // Update the value of the text input
	             textInput.value = newFileName;
	             closeModal(errorElementId);
	         }
	     } else {
	         textInput.value = '';
	         fileInput.value = '';
	         closeModal(errorElementId);
	     }
	 }


	 function updateDisabledField(input) {
	 	const disabledField = document.getElementById('disabledField');

	 	if (input.value.trim() !== '') {
	 		disabledField.value = '00';
	 	} else {
	 		disabledField.value = '';
	 	}
	 }



 document.querySelector('label[for="attachmentPdf"]').addEventListener('click', function(e) {
        e.preventDefault();
    });
    
    document.querySelector('label[for="attachmentWord"]').addEventListener('click', function(e) {
        e.preventDefault();
    });


function updateFields() {
	//const stmNumber = document.getElementById('stmNumber').value;
	//const disabledField = document.getElementById('disabledField');

	//const linkDestination = document.getElementById('linkDestination');

	// Assuming you want to concatenate stmNumber and disabledField values            
	//const concatenatedValue = stmNumber + disabledField.value;

	// Update linkDestination field value
	//linkDestination.value = concatenatedValue;
}


        // Add an event listener to the date input
        document.getElementById('lastUpdated').addEventListener('blur', function () {
            validateDate(this);
        });

// Set the duration for the messages to be displayed in milliseconds (e.g., 5000 for 5 seconds)
var messageDuration = 5000;

// Function to hide the success message after a certain duration
function hideSuccessMessage() {
	var successMessageDiv = document.getElementById('successModal');
	if (successMessageDiv) {
		successMessageDiv.style.display = 'none';
	}
}

// Function to hide the error message after a certain duration
function hideErrorMessage() {
	var errorMessageDiv = document.getElementById('errorModal');
	if (errorMessageDiv) {
		errorMessageDiv.style.display = 'none';
	}
}

// Set timeouts to hide messages after the specified duration
setTimeout(hideSuccessMessage, messageDuration);
		  setTimeout(hideErrorMessage, messageDuration);
