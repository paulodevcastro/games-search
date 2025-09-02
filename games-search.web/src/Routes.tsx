import { BrowserRouter, Routes as Rt, Route } from 'react-router-dom';
import Home from './pages/Home';
import Header from './components/Header';
import Records from './pages/Records';
import Charts from './pages/Charts';

const Routes = () => (
    <BrowserRouter>
        <Header/>
        <Rt>
            <Route path='/' element={<Home/>}/>
            <Route path='/records' element={<Records/>}/>
            <Route path='/charts' element={<Charts/>}/>
        </Rt>
    </BrowserRouter>
)

export default Routes;