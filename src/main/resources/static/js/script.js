const search=()=>{
    // console.log("searching");
    let query = $("#search-input").val();
    console.log(query);

    if(query== ''){

    }else{
        
    }
}

const is_authenticated=()=>{
     is_authenticated = fetchingService.authenticate(loginForm.getId(),loginForm.getUsername(), loginForm.getPassword());
     return is_authenticated;
}