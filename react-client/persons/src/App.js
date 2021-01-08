import React, { Component } from 'react';
import './App.css';
import Persons from './Persons/Persons';
import axios from 'axios';
import PersonDet from './Persons/PersonDet/PersonDet';

class App extends Component {
  state = {
    persons: [],
    showDetails: false,
    personDetails: null
  }

  componentDidMount() {
    axios.get('http://localhost:8080/all').then(response => {
      const persons = response.data;
      this.setState({persons: persons});
    });
  }

  showDetailsHandler = (personId) => {
    axios.get('http://localhost:8080/person?id=' + personId).then(response => {
      const person = response.data;
      this.setState({personDetails: person});
    });
  }


  
  render() {
    let pers = null;
    if(this.state.personDetails !== null) {
      pers = <PersonDet person={this.state.personDetails} />
    }
    return (
      <div className="App">
        {pers}
       <Persons persons={this.state.persons} showDetailsHandler={this.showDetailsHandler}/>
      </div>
    );
  }
}

export default App;
