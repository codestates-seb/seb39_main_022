import { Link } from 'react-router-dom';

const Missing = () => {
    return (
        <main className='Missing'>
            <h2>Page Not Found</h2>
            페이지 연결 실패!
            <p><Link to='/'>홈으로 돌아가기</Link></p>
        </main>
    )
}

export default Missing
