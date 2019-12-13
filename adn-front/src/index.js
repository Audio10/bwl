import React from 'react'
import ReactDom from 'react-dom'
import "bootstrap/dist/css/bootstrap.css"
import Login from './pages/Login'

const container = document.getElementById('app')

ReactDom.render(<Login/>, container)
