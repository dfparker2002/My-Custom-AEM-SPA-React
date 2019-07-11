import React, {Component} from 'react';
import {MapTo} from '@adobe/cq-react-editable-components';

export default class Title extends Component {
    get headingType(){
        if(!this.props.type){
          return 'h1';
        }else{
          return this.props.type;
        }
    }

    render() {
          const htmlDom = React.createElement(this.headingType, {}, this.props.title);
            return <div className="Title-class">{htmlDom} </div>;
    }
}

MapTo('wknd-events/components/content/title')(Title);