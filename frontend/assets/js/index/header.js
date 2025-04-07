document.addEventListener('DOMContentLoaded', () => {
    const menuIcon = document.querySelector('.menu-icon');
    const closeIcon = document.querySelector('.close-icon');
    const navMenu = document.querySelector('.nav-menu');
    const links = document.querySelectorAll('.navbar-list li a');

    function resetMenu() {
        if (window.innerWidth > 1000) {
            navMenu.classList.remove('active');
            closeIcon.style.display = 'none';
            menuIcon.style.display = 'none';
        } else {
            navMenu.classList.remove('active');
            closeIcon.style.display = 'none';
            menuIcon.style.display = 'flex';
        }
    }

    menuIcon.addEventListener('click', () => {
        navMenu.classList.add('active');
        menuIcon.style.display = 'none';
        closeIcon.style.display = 'block';
    });

    closeIcon.addEventListener('click', () => {
        navMenu.classList.remove('active');
        closeIcon.style.display = 'none';
        menuIcon.style.display = 'flex';
    });

    links.forEach(link => {
        link.addEventListener('click', function () {
            navMenu.classList.remove('active');
            closeIcon.style.display = 'none';
            if (window.innerWidth <= 950) {
                menuIcon.style.display = 'flex';
            } else {
                menuIcon.style.display = 'none'
            }
        });
    });

    window.addEventListener('resize', resetMenu);
    resetMenu();
});