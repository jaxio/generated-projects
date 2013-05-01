jQuery(function() {

	// HACK to make p:layout work with chromeshades (we just add the !important)
	$(PrimeFaces.escapeClientId('form:top')).css("display","block !important");
	$(PrimeFaces.escapeClientId('form:center')).css("display","block !important");
	$(PrimeFaces.escapeClientId('form:bottom')).css("display","block !important");

	// Add some ARIA role here
	$(PrimeFaces.escapeClientId('form:center')).attr("role","main");
	$(PrimeFaces.escapeClientId('form:bottom')).attr("role","contentinfo");
	$(".aria-role-presentation").attr("role", "presentation");
	$(".aria-search-button").attr("aria-controls", "searchResultsRegion");
	$(".aria-save-button").attr("aria-controls", "messagesRegion");
	
	/* temporary fix for keyboard menu navigation */
	$('.ui-menuitem-link').focus(function() { jQuery(this).parent().toggleClass('ui-state-focus');})
						  .blur(function() { jQuery(this).parent().removeClass('ui-state-focus');});

	/* Set the default button when user press enter */
	$("form input, form select").live("keypress", function (e) {
		if ($(this).parents("form").find("button[type=submit].default").length <= 0) {
			return true;
		}
		
		if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
			$(this).parents("form").find("button[type=submit].default").click();
			return false;
		} else {
			return true;
		}
	});

	/* keep focus inside askForDeleteDialog */
	$(PrimeFaces.escapeClientId('form:askForDeleteDialogNo')).live('keydown', function(e) { 
		if ((!e.shiftKey) && ((e.which && e.which == 9) || (e.keyCode && e.keyCode == 9))) {
			if (e.preventDefault) {
				e.preventDefault();
			}
			jQuery(PrimeFaces.escapeClientId('form:askForDeleteDialogYes')).focus();
		}
	});
	$(PrimeFaces.escapeClientId('form:askForDeleteDialogYes')).live('keydown', function(e) { 
		if ((e.shiftKey) && ((e.which && e.which == 9) || (e.keyCode && e.keyCode == 9))) {
			if (e.preventDefault) {
				e.preventDefault();
			}
			jQuery(PrimeFaces.escapeClientId('form:askForDeleteDialogNo')).focus();
		}
	});

	/* keep focus inside askForSaveDialog */
	$(PrimeFaces.escapeClientId('form:askForSaveDialogNo')).live('keydown', function(e) { 
		if ((!e.shiftKey) && ((e.which && e.which == 9) || (e.keyCode && e.keyCode == 9))) {
			if (e.preventDefault) {
				e.preventDefault();
			}
			jQuery(PrimeFaces.escapeClientId('form:askForSaveDialogYes')).focus();
		}
	});
	$(PrimeFaces.escapeClientId('form:askForSaveDialogYes')).live('keydown', function(e) { 
		if ((e.shiftKey) && ((e.which && e.which == 9) || (e.keyCode && e.keyCode == 9))) {
			if (e.preventDefault) {
				e.preventDefault();
			}
			jQuery(PrimeFaces.escapeClientId('form:askForSaveDialogNo')).focus();
		}
	});
});

APP = {};

//-------------------------------------
// Gain focus on dialog
//-------------------------------------
APP.focusAskForDeleteDialog = function() {
	jQuery(PrimeFaces.escapeClientId('form:askForDeleteDialogNo')).focus();
};

APP.focusAskForSaveDialog = function() {
	jQuery(PrimeFaces.escapeClientId('form:askForSaveDialogYes')).focus();
};

APP.focusTo = function(jsfId) {
	if (jQuery(PrimeFaces.escapeClientId(jsfId +"_input")).length == 1) { // target the input of the autocomplete
		jQuery(PrimeFaces.escapeClientId(jsfId + "_input")).focus();
	} else {
		jQuery(PrimeFaces.escapeClientId(jsfId)).focus();
	}
};	

//---------------------------------------
// Aria live region related
//---------------------------------------
/* todo: localization */
APP.updateSearchResultsRegion = function(text) {
	jQuery("#searchResultsRegion").text(text);
};	

//-------------------------------------
//Menu shortcuts
//-------------------------------------

APP.menu = {};
APP.menu.call = function(idToClick) {
	jQuery(PrimeFaces.escapeClientId(idToClick)).click();	
	return false;
};
APP.menu.cancel = function() {
	return APP.menu.call('form:cancel');
};
APP.menu.back = function() {
	return APP.menu.call('form:back');
};
