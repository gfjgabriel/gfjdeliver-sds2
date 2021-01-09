import './styles.css';
import {ReactComponent as YoutubeIcon} from './youtube.svg';
import {ReactComponent as LinkedinIcon} from './linkedin.svg';
import {ReactComponent as InstagramIcon} from './instagram.svg';

function Footer() {
    return (
       <footer className="main-footer">
           App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
           <div className="footer-icons">
               <a href="https://www.youtube.com/channel/UCcBxIeGqry2ZQQfrWFmYCJA" target="_new">
                    <YoutubeIcon />
               </a>
               <a href="https://linkedin.com/in/gfjgabriel" target="_new">
                   <LinkedinIcon />
               </a>
               <a href="https://instagram.com/gfjgabriel" target="_new">
                   <InstagramIcon />
               </a>
           </div>
       </footer>
    )
}

export default Footer;