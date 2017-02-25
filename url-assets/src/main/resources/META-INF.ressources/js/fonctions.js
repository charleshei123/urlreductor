function afficherCacher(id)
{
    
    console.log(document.getElementById(id));
    if(document.getElementById(id).style.display == "none")
    {
        document.getElementById(id).setAttribute("style", "display:true");
    }
    else
    {
        document.getElementById(id).setAttribute("style", "display:none");
    }
}