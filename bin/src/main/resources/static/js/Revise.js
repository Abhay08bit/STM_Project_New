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


var stmNo = document.getElementById('stmNumber').value;
var stmVersion = document.getElementById('revisionNumber').value;


function updatePdfFileName(textInputId, fileInputId, errorElementId) {
	const textInput = document.getElementById(textInputId);
	const fileInput = document.getElementById(fileInputId);
	//const errorElement = document.getElementById(errorElementId);

	if (fileInput.files.length > 0) {
		const fileName = fileInput.files[0].name;
		const fileExtension = fileName.split('.').pop().toLowerCase();

		if (fileExtension !== 'pdf') {
			fileInput.value = '';			
			openModal(errorElementId);
		} else {
			// Construct the new file name (STMStmNoRevisionNo.extension)
			    const formattedRevision = parseInt(stmVersion) + 1;			    
                const paddedRevision = formattedRevision.toString();
                const revision="0"+paddedRevision;               
                const newFileName = "STM" + stmNo + revision + "." + fileExtension;

			// Update the value of the text input
			textInput.value = newFileName;
			closeModal(errorElementId);
		}
	} else {		
		fileInput.value='';
		closeModal(errorElementId);
	}
}
function updateWordFileName(textInputId, fileInputId, errorElementId) {
	const textInput = document.getElementById(textInputId);
	const fileInput = document.getElementById(fileInputId);
	//const errorElement = document.getElementById(errorElementId);

	if (fileInput.files.length > 0) {
		const fileName = fileInput.files[0].name;
		const fileExtension = fileName.split('.').pop().toLowerCase();

		if (fileExtension !== 'doc' && fileExtension !== 'docx') {			
			fileInput.value='';			
			openModal(errorElementId);
		} else {
			// Construct the new file name (STMStmNoRevisionNo.extension)
			    const formattedRevision = parseInt(stmVersion) + 1;			    
                const paddedRevision = formattedRevision.toString();
                const revision="0"+paddedRevision;               
                const newFileName = "STM" + stmNo + revision + "." + fileExtension;

			// Update the value of the text input
			textInput.value = newFileName;
			closeModal(errorElementId);
		}
	} else {		
		fileInput.value='';		
		closeModal(errorElementId);
	}
}

 document.querySelector('label[for="attachmentPdf"]').addEventListener('click', function(e) {
        e.preventDefault();
    });
    
    document.querySelector('label[for="attachmentWord"]').addEventListener('click', function(e) {
        e.preventDefault();
    });

function confirmRevise() {
	console.log("Confirming revise...");
	closeModal('reviseConfirmation');
	document.getElementById('reviseForm').submit();
}


function validateDateFormat(inputField) {
	var enteredDate = inputField.value;
	var dateFormat = /^(\d{4})\/(\d{2})\/(\d{2})$/;

	if (!dateFormat.test(enteredDate)) {
		alert("Invalid date format. Please enter the date in yyyy/MM/dd format.");
		// Clear the input field or perform any other actions as needed
		inputField.value = "";
	}
}
document.addEventListener('DOMContentLoaded', function () {
            const lastUpdatedInput = document.getElementById('lastUpdated');
            lastUpdatedInput.dataset.initialValue = lastUpdatedInput.value;
        });

        // Function to fetch the initial value
        function getInitialValue() {
            const lastUpdatedInput = document.getElementById('lastUpdated');
            return lastUpdatedInput.dataset.initialValue || '';
        }
        
function validateDate(input) {
    const dateInput = input.value;
    const dateArray = dateInput.split('/');
    const initialValue = getInitialValue();
    if (dateArray.length === 3) {
        const year = parseInt(dateArray[0], 10);
        const month = parseInt(dateArray[1], 10);
        const day = parseInt(dateArray[2], 10);

        // Check if the month is valid
        if (month < 1 || month > 12) {
            openModal('modalErrorMonth');
            input.value = initialValue;
            return;
        }

        // Check if the day is valid for the given month
        const daysInMonth = new Date(year, month, 0).getDate();
        if (day < 1 || day > daysInMonth) {
            openModal('modalErrorDay');
            input.value = initialValue;
            return;
        }
    } else {
        openModal('modalErrorFormat');
        input.value = initialValue;
        return;
    }
}
function formatDraftingDate(input) {
        // Remove any non-numeric characters from the input
        var numericInput = input.value.replace(/\D/g, '');

        // Check if the input has at least 8 characters (yyyymmdd)
        if (numericInput.length >= 8) {
            // Extract year, month, and day
            var year = numericInput.substring(0, 4);
            var month = numericInput.substring(4, 6);
            var day = numericInput.substring(6, 8);

            // Format the date as yyyy/mm/dd
            var formattedDate = year + '/' + month + '/' + day;
            // Set the formatted date back to the input
            input.value = formattedDate;
        }
    }
    document.addEventListener("DOMContentLoaded", function() {
        var revisionNumberInput = document.getElementById('revisionNumber');
        var currentRevision = parseInt(revisionNumberInput.value) + 1;
        var formattedRevision = currentRevision.toString();
        var revision="0"+formattedRevision;
        revisionNumberInput.value = revision;
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

 
 
 
