
for (var j=0; j < Projects.length; j++) {

        var key = Object.keys(Projects[j]);

        for (var i=0; i < Projects[j][key].length; i++) {

            var projectType = j + 1;
            var projectNumber = i + 1;
            var projectName = Projects[j][key][i].name;
            var projectTitle = Projects[j][key][i].title;
            var imageSource = Projects[j][key][i].imageSrc;
            var link1name = Projects[j][key][i].link1name;
            var link2name = Projects[j][key][i].link2name;
            var link1url = Projects[j][key][i].link1url;
            var link2url = Projects[j][key][i].link2url;
            var comment = Projects[j][key][i].comment;

           AddHtml.createProjectCard(projectType, projectNumber, projectName, imageSource, link1url, link2url, link1name, link2name, comment);
           AddHtml.createModal(projectType, projectNumber, projectName, projectTitle, imageSource, comment);
        }
    }

// Creating an array of new AnimaObjs. Requires a jQuery wrapper for elements.
var animaObjs = [new AnimaObj($(".add-animation1"), $(".animation-container1"), $(".row1"), $(".sec-2"), $(".sec-3")),
                 new AnimaObj($(".add-animation2"), $(".animation-container2"), $(".row2"), $(".sec-1"), $(".sec-3")),
                 new AnimaObj($(".add-animation3"), $(".animation-container3"), $(".row3"), $(".sec-1"), $(".sec-2"))];

// Calling initAmination after creation of animaObjs Array to initialize the animation.
// This sets the element property values and initiates the scroll listener.
initAnimation();

// Creating an array of new ClickToggleObj. Requires a jQuery wrapper for elements.
var toggleObjs = [new ClickToggleObj($(".add-animation1"), $(".row1"), $(".sec-2"), $(".sec-3")),
                 new ClickToggleObj($(".add-animation2"), $(".row2"), $(".sec-1"), $(".sec-3")),
                 new ClickToggleObj($(".add-animation3"), $(".row3"), $(".sec-1"), $(".sec-2"))];

// Calling the showHide method on each ClickToggleObj to add a click listener and to initially hide the elements.
toggleObjs.forEach(function(element, index, array) {
    element.showHide();
});

var links = document.querySelectorAll('a');
for(var i=0;i<links.length;i++) {
    links[i].addEventListener('click',function (e) {
            e.stopPropagation();
        },false);
}