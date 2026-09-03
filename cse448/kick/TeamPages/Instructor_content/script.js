'use strict';




const PROJECTS = [
    { id: 'p1', name: 'Great Expectations' },
    { id: 'p2', name: 'A Town Like Alice' },
    { id: 'p3', name: 'Strictly Ballroom' },
    { id: 'p4', name: 'The Miami Bulletin' }
   ];
   
   // voting tally construct
   const TALLY = PROJECTS.reduce((acc, p) => (acc[p.id] = 0, acc), {});
   
   
   function initializeVoteGrid() {
    renderProjectList();
    renderResults();
   
   
    // Vote handler
    // on each click, increment the tally and re-render
    const $projectList = $('#projectList');
    if ($projectList.length) {
      $projectList.on('click', 'button[data-project]', function () {
        const id = $(this).data('project');
        if (Object.prototype.hasOwnProperty.call(TALLY, id)) {
          TALLY[id] += 1;
          renderResults();
          const results = document.getElementById('results');
          if (results && typeof results.scrollIntoView === 'function') {
            results.scrollIntoView({ behavior: 'smooth', block: 'start' });
          }
        }
      });
    }
   
   
    // clear voting tally for all projects
    $('#resetVotes').on('click', function () {
      Object.keys(TALLY).forEach(k => TALLY[k] = 0);
      renderResults();
    });
   }
   
   // render project list including 'vote' button
   function renderProjectList() {
    const $ul = $('#projectList');
    if (!$ul.length) return;
    const items = PROJECTS.map(p => `
      <li class="list-group-item d-flex justify-content-between align-items-center">
        <span>${escapeHtml(p.name)}</span>
        <button type="button" class="btn btn-sm btn-primary" data-project="${p.id}">Vote</button>
      </li>
    `).join('');
    $ul.html(items);
   }
   
   
   // render bar by project
  function renderResults() {
    const $out = $('#results');
    if (!$out.length) return; // if output is empty, exit

    // calculate the bar length and render
    //get max
    const max = Math.max(1, ...Object.values(TALLY));
    
    // for each project, calc its percent of max for scale
    // and return new html
    const html = PROJECTS.map(p => {
      const count = TALLY[p.id];
      const pct = Math.round((count / max) * 100); // scale bars by current leader
      return `
        <div class="d-flex justify-content-between align-items-center">
          <strong>${escapeHtml(p.name)}</strong>
          <span class="badge badge-light">${count}</span>
        </div>
        <div class="progress mb-2">
          <div class="progress-bar" role="progressbar" style="width:${pct}%"
              aria-valuenow="${pct}" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
      `;
    }).join('');
    $out.html(html);
  }
   
   
   // Minimal sanitizer to avoid HTML injection in names
   function escapeHtml(s) {
    return String(s)
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;')
      .replace(/'/g, '&#039;');
   }
   
   
   
   
   
