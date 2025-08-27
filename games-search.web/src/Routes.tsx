import { BrowserRouter, Routes as Rt, Route } from 'react-router-dom';
import Home from './pages/Home';
import Header from './components/Header';
import Records from './pages/Records';

const Routes = () => (
    <BrowserRouter>
        <Header/>
        <Rt>
            <Route path='/' element={<Home/>}/>
            <Route path='/records' element={<Records/>}/>
        </Rt>
    </BrowserRouter>
)

export default Routes;