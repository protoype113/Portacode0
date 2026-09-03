'use strict';

/* -----------------------------------------------------------
   Teams source (your original data, unchanged)
----------------------------------------------------------- */
const getTeams = () => {
  // Simulate a dB return of all students
  // pick a record and update the id, team name, page_url, and team members
  // 
  // SAMPLE RECORD
  // {
    //   "id": put_a_unique_integer_here ,
    //   "team_name": "Team Name Goes Here",
    //   "page_url": "TeamPages/putTheNameHere.html",
    //   "team_members":
    //     [
    //       { "first_name": "FirstName1", "last_name": "LastName1", "email": "muid@miamioh.edu" },
    //       { "first_name": "FirstName2", "last_name": "LastName2", "email": "muid@miamioh.edu" },
    //       { "first_name": "FirstName3", "last_name": "LastName3", "email": "muid@miamioh.edu" }
    //     ]
    // }

  return JSON.parse(
     `[
        {
        "id": 1,
        "team_name": "Instructor",
        "page_url": "TeamPages/instructor_page.html",
        "team_members":
          [
            {
              "first_name": "Professor",
              "last_name": "Stahr",
              "email": "stahrlc@miamioh.edu"
            }
          ]
        }
        ,
        {
          "id": 123 ,
          "team_name": "Team Name Goes Here",
          "page_url": "TeamPages/putTheNameHere.html",
          "team_members":
            [
              { "first_name": "FirstName1", "last_name": "LastName1", "email": "muid@miamioh.edu" },
              { "first_name": "FirstName2", "last_name": "LastName2", "email": "muid@miamioh.edu" },
              { "first_name": "FirstName3", "last_name": "LastName3", "email": "muid@miamioh.edu" }
            ]
        }
       
      ]`
      // Temporary change to allow rebase.
  );
};


// Page navigation
function goToNewPage(url) {
  window.location.href = url;
}